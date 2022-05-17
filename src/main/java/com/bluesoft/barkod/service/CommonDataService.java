package com.bluesoft.barkod.service;

import java.util.List;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.model.ActionResponse;
import com.bluesoft.barkod.model.CalculatedDataDTO;
import com.bluesoft.barkod.model.CommonActionRequest;
import com.bluesoft.barkod.model.MobilActionRequest;
import com.bluesoft.barkod.model.MobilActionResponse;
import com.bluesoft.barkod.model.SanalBarkodResponse;
import com.bluesoft.barkod.model.commonDataDTO;

public interface CommonDataService {

	List<commonDataDTO> getCommonDataList(Long depoId, Long projeId,Long projectDevreId);

	ActionResponse getTransactionList(CommonActionRequest request);
	
	public MobilActionResponse userActions(MobilActionRequest request);
	
	public List<AkisHavuz> getHavuzList();
	
	public CalculatedDataDTO calculateData(Long depoId, Long projeId,Long projectDevreId,Long priorty);
	
	public SanalBarkodResponse getSanalBarkodDetay(Long sanalBarkodNo);

}