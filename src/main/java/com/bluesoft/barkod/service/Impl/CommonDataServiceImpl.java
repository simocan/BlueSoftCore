package com.bluesoft.barkod.service.Impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.entity.AkisHavuzPersonel;
import com.bluesoft.barkod.entity.AkisProgress;
import com.bluesoft.barkod.entity.TblSanalBarkod;
import com.bluesoft.barkod.model.ActionResponse;
import com.bluesoft.barkod.model.CommonActionRequest;
import com.bluesoft.barkod.model.MobilActionRequest;
import com.bluesoft.barkod.model.MobilActionResponse;
import com.bluesoft.barkod.model.SanalBarkodResponse;
import com.bluesoft.barkod.model.CalculatedDataDTO;
import com.bluesoft.barkod.model.commonDataDTO;
import com.bluesoft.barkod.repository.AkisHavuzRepository;
import com.bluesoft.barkod.repository.CommonDataRepository;
import com.bluesoft.barkod.repository.SanalBarkodRepository;
import com.bluesoft.barkod.service.CommonDataService;

@Service
public class CommonDataServiceImpl implements CommonDataService {

	@Autowired
	private CommonDataRepository commonDataRepository;

	@Autowired
	private AkisHavuzRepository akisHavuzRepository;

	@Autowired
	private SanalBarkodRepository sanalBarkodRepository;

	@Override
	public List<commonDataDTO> getCommonDataList(Long depoId, Long projeId, Long projectDevreId) {
		return commonDataRepository.getCommonDataList(depoId, projeId, projectDevreId);
	}

	@Override
	public ActionResponse getTransactionList(CommonActionRequest request) {
		ActionResponse response = new ActionResponse();

		List<String> havuzStrList = new ArrayList<String>();

		try {
			TblSanalBarkod sanalBarkod = sanalBarkodRepository.getSanalBarkod(request.getSanalBarkodNo());
			if (sanalBarkod != null) {
				AkisHavuz currentHavuz = akisHavuzRepository.getAkisHavuz(sanalBarkod.getHavuz());

				if (currentHavuz != null) {
					List<AkisHavuz> havuzList = getNextHavuz(currentHavuz);
					if (havuzList != null && !havuzList.isEmpty()) {
						for (AkisHavuz akisHavuz : havuzList) {
							havuzStrList.add(akisHavuz.getName());
						}

						List<AkisHavuzPersonel> userHavuz = akisHavuzRepository
								.getAkisHavuzPersonelListByPersonel(request.getPersonelId(), havuzStrList);
						if (userHavuz != null) {
							List<AkisHavuz> personelHavuzList = akisHavuzRepository.getAkisHavuzList(
									userHavuz.stream().map(AkisHavuzPersonel::getHavuz).collect(Collectors.toList()));
							response.setActionList(
									personelHavuzList.stream().map(AkisHavuz::getName).collect(Collectors.toList()));
							response.setCode(1);
						}

					}
				}
			}

			if (response.getActionList().isEmpty()) {
				response.setMessage("Kullanıcı Yetkisi Bulunamadı");
			}

		} catch (Exception e) {
			response.setMessage("Kullanıcı Yetkisi Bulunamadı");
		}

		return response;
	}

	private List<AkisHavuz> getNextHavuz(AkisHavuz currentHavuz) {
		List<AkisHavuz> havuzList = new ArrayList<AkisHavuz>();

		if (currentHavuz.getState() != null && !currentHavuz.getState().isEmpty()) {
			AkisHavuz havuz = akisHavuzRepository.getAkisHavuz(currentHavuz.getState());
			havuzList.add(havuz);
		} else {

			havuzList = akisHavuzRepository.getAkisHavuzListByPriorty(currentHavuz.getPriorty() + 1);
		}
		return havuzList;
	}

	@Override
	@Transactional
	public MobilActionResponse userActions(MobilActionRequest request) {

		MobilActionResponse response = new MobilActionResponse();
		// akışın şuanki bilgileri
		try {

			TblSanalBarkod tblSanalBarkod = sanalBarkodRepository.getSanalBarkod(request.getSanalBarkod());
			AkisHavuz tblSanalBarkodHavuz = akisHavuzRepository.getAkisHavuz(tblSanalBarkod.getHavuz());
			if (tblSanalBarkod != null && tblSanalBarkodHavuz != null) {
				AkisHavuz nextHavuz = akisHavuzRepository.getAkisHavuz(request.getAction());
				validate(request, response, tblSanalBarkod, tblSanalBarkodHavuz, nextHavuz);

				AkisProgress progress = new AkisProgress();
				progress.setActionDate(new Date());
				progress.setActionUserId(request.getPersonelId());
				progress.setName(request.getAction());
				progress.setSanalBarkodNo(request.getSanalBarkod());
				progress.setCurrentHavuz(nextHavuz.getCurrentHavuz());
				progress.setActionTime(new Date());
				progress.setHavuzAck(nextHavuz.getAck());

				akisHavuzRepository.insertAkisProgres(progress);
				sanalBarkodRepository.update(request.getSanalBarkod(), request.getPersonelId(), request.getAction());

				response.setCode(0);
				response.setActionCode("SUCCES");
				response.setMessage("Başarılı");
				return response;

			} else {
				return prepareFailResponse(response, "FAIL");
			}

		} catch (Exception e) {
			return prepareFailResponse(response, e.getMessage());
		}

	}

	private void validate(MobilActionRequest request, MobilActionResponse response, TblSanalBarkod tblSanalBarkod,
			AkisHavuz tblSanalBarkodHavuz, AkisHavuz nextHavuz) throws Exception {
		if (nextHavuz == null) {
			throw new Exception("BOS_HAVUZ");
		} else if (nextHavuz.getTip() != null && nextHavuz.getTip().equals(tblSanalBarkodHavuz.getTip())) {
			if (request.getPersonelId() != tblSanalBarkod.getPersonelId()) {
				throw new Exception("Akış Başka bir personelde");
			}
		}

		if (!(tblSanalBarkodHavuz.getState()==null && tblSanalBarkodHavuz.getPriorty() + 1 == nextHavuz.getPriorty())) {
//			throw new Exception("Yanlış Havuz");
		}
	}

	private MobilActionResponse prepareFailResponse(MobilActionResponse response, String message) {
		response.setCode(0);
		response.setActionCode("FAIL");
		response.setMessage(message);
		return response;
	}

	@Override
	public List<AkisHavuz> getHavuzList() {
		return commonDataRepository.getHavuzList();
	}

	@Override
	public CalculatedDataDTO calculateData(Long depoId, Long projeId, Long projectDevreId, Long priorty) {
		 List<commonDataDTO> allList=getCommonDataList(depoId, projeId, projectDevreId);
		 
	     BigDecimal totalAgirlik = allList.stream().map(x -> x.getAgirlik()).reduce(BigDecimal.ZERO, BigDecimal::add);  
		 
		 List<commonDataDTO> priortyList=commonDataRepository.getCommonDataList(depoId, projeId, projectDevreId,priorty);
		 
		 BigDecimal priortyTotalAgirlik = priortyList.stream().map(x -> x.getAgirlik()).reduce(BigDecimal.ZERO, BigDecimal::add); 
		 
		 CalculatedDataDTO dto=new CalculatedDataDTO();
		 dto.setPriorty(String.valueOf(priorty));
		 dto.setPercent(percentage(priortyTotalAgirlik,totalAgirlik).setScale(0));
		
		 return dto;
	}
	
	public static BigDecimal percentage(BigDecimal base, BigDecimal pct){
		if(BigDecimal.ZERO.compareTo(base)==0) return BigDecimal.ZERO;
	    return base.divide(pct, 2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
	}

	@Override
	public SanalBarkodResponse getSanalBarkodDetay(Long sanalBarkodNo) {
		return commonDataRepository.getSanalBarkodDetay(sanalBarkodNo);
	}

}
