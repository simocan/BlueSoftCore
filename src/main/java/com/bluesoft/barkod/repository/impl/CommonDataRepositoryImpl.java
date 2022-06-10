package com.bluesoft.barkod.repository.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.model.GrafikOutputData;
import com.bluesoft.barkod.model.SanalBarkodResponse;
import com.bluesoft.barkod.model.commonDataDTO;
import com.bluesoft.barkod.repository.CommonDataRepository;

@Repository
public class CommonDataRepositoryImpl implements CommonDataRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private String SELECT_DASHBOARD_DATA = " SELECT  SANAL.SANALBARKOD,SANAL.TARIH, ISNULL(SANAL.AGIRLIK,0) AS AGIRLIK,"
			+ " SANAL.SPOOLNO,SANAL.HAVUZ,SANAL.PERSONEL_ID,PROJE.ADI AS PROJE_ADI,PROJE.ID AS PROJE_ID,FATURA.DEPOID,FATURA.PROJEID "
			+ ",TP.ADI AS DEVRE_ADI,H.COLOR,H.ACK FROM TBL_SANALBARKOD SANAL "
			+ " LEFT JOIN TBL_STOKHAREKETLERI HAREKET ON HAREKET.SPOOLNO=SANAL.SPOOLNO "
			+ " LEFT JOIN TBL_FATURALAR FATURA ON FATURA.ID=HAREKET.FATURAID "
			+ " LEFT JOIN TBL_PROJELER PROJE ON PROJE.ID=FATURA.PROJEID "
			+ " LEFT JOIN TBL_PROJEDEVRELER TP ON TP.ID=FATURA.PROJEDEVREID "
			+ " LEFT JOIN AKIS_HAVUZ H ON H.HAVUZ=SANAL.HAVUZ WHERE FATURA.DEPOID=?1 "
			+ " AND PROJE.ID=ISNULL(?2,PROJE.ID) and TP.ID=ISNULL(?3,TP.ID) GROUP BY SANAL.SANALBARKOD,"
			+ " SANAL.SPOOLNO,SANAL.HAVUZ,SANAL.PERSONEL_ID,PROJE.ADI,PROJE.ID,FATURA.DEPOID,FATURA.PROJEID,TP.ADI,H.COLOR,H.ACK,SANAL.TARIH,SANAL.AGIRLIK";

	private String SELECT_DASHBOARD_DATA_WITH_PRIORTY = "  SELECT  SANAL.SANALBARKOD, ISNULL(SANAL.AGIRLIK,0) AS AGIRLIK,"
			+ " SANAL.SPOOLNO,SANAL.HAVUZ,PROJE.ADI AS PROJE_ADI,PROJE.ID AS PROJE_ID,H.PRIORTY,"
			+ " FATURA.DEPOID,TP.ADI AS DEVRE_ADI FROM TBL_SANALBARKOD SANAL"
			+ " LEFT JOIN TBL_STOKHAREKETLERI HAREKET ON HAREKET.SPOOLNO=SANAL.SPOOLNO "
			+ " LEFT JOIN TBL_FATURALAR FATURA ON FATURA.ID=HAREKET.FATURAID "
			+ "		 LEFT JOIN TBL_PROJELER PROJE ON PROJE.ID=FATURA.PROJEID "
			+ "		 LEFT JOIN TBL_PROJEDEVRELER TP ON TP.ID=FATURA.PROJEDEVREID "
			+ "		 LEFT JOIN AKIS_HAVUZ H ON H.HAVUZ=SANAL.HAVUZ WHERE FATURA.DEPOID=?1 "
			+ "		 AND PROJE.ID=ISNULL(?2,PROJE.ID) and TP.ID=ISNULL(?3,TP.ID) AND H.PRIORTY>=ISNULL(?4,H.PRIORTY) GROUP BY SANAL.SANALBARKOD,"
			+ "		SANAL.SPOOLNO,SANAL.HAVUZ,PROJE.ADI,PROJE.ID,FATURA.DEPOID,"
			+ "		TP.ADI,SANAL.AGIRLIK,H.PRIORTY ";

	private String SELECT_HAVUZ_LIST = "SELECT DISTINCT PRIORTY,CURRENT_HAVUZ ,ACK FROM AKIS_HAVUZ";

	private String SELECT_BARKOD_DETAY = "SELECT SANAL.SPOOLNO,SANAL.DUZEY,TP.ADI from dbo.TBL_SANALBARKOD SANAL "
			+ " LEFT JOIN TBL_FATURALAR FATURA ON FATURA.ID=SANAL.FATURAID "
			+ " LEFT JOIN TBL_PROJEDEVRELER TP ON TP.ID=FATURA.PROJEDEVREID "
			+ " LEFT JOIN TBL_PROJELER PROJE ON PROJE.ID=FATURA.PROJEID WHERE SANAL.SANALBARKOD=?1 ";
	
	private String SELECT_GRAFIK_DATA = "SELECT  COUNT(SDK.HAVUZ) AS ISLEMDURUMLARI, SDK.HAVUZ, TB.PROJEID, TP.ADI AS PROJEADI, TT.ID AS TERSANEID "
		+ " FROM  dbo.TBL_SANALBARKOD AS SDK INNER JOIN dbo.TBL_FATURALAR AS TB ON TB.ID = SDK.FATURAID LEFT OUTER JOIN "
	    + " dbo.TBL_PROJELER AS TP ON TP.ID = TB.PROJEID LEFT OUTER JOIN dbo.DEPO AS D ON D.ID = TB.DEPOID LEFT OUTER JOIN "
	    + " dbo.TBL_TERSANELER AS TT ON TT.ID = D.TERSANEID LEFT JOIN TBL_PROJEDEVRELER TPJ ON TPJ.ID=TB.PROJEDEVREID "
	    + " WHERE tb.PROJEID=?1 AND TPJ.ID=ISNULL(?2,TPJ.ID) GROUP BY SDK.HAVUZ, TB.PROJEID, TP.ADI, TT.ID ";
			

	@Transactional
	@Override
	public List<commonDataDTO> getCommonDataList(Long depoId, Long projeId, Long projecDevreId) {

		List<commonDataDTO> responseList = new ArrayList<commonDataDTO>();

		Query q = entityManager.createNativeQuery(SELECT_DASHBOARD_DATA, Tuple.class);
		q.setParameter(1, depoId);
		q.setParameter(2, projeId);
		q.setParameter(3, projecDevreId);
		List<Tuple> resultList = q.getResultList();

		for (Tuple tuple : resultList) {
			commonDataDTO dto = new commonDataDTO();
			dto.setSpoolNo((String) tuple.get("SPOOLNO"));
			dto.setSanalBarkodNo(String.valueOf(tuple.get("SANALBARKOD")));
			dto.setRowColor(String.valueOf(tuple.get("COLOR")));
			dto.setHavuz(String.valueOf(tuple.get("HAVUZ")));
			dto.setAck(String.valueOf(tuple.get("ACK")));
			dto.setDevreAdi(String.valueOf(tuple.get("DEVRE_ADI")));
			dto.setProjeAdi(String.valueOf(tuple.get("PROJE_ADI")));
			dto.setAgirlik((BigDecimal) tuple.get("AGIRLIK"));

			DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:ss");
			if (tuple.get("TARIH") != null) {
				dto.setTarih(formatter.format((Date) tuple.get("TARIH")));
			}
			responseList.add(dto);
		}

		return responseList;
	}

	@Override
	public List<AkisHavuz> getHavuzList() {
		List<AkisHavuz> responseList = new ArrayList<AkisHavuz>();

		Query q = entityManager.createNativeQuery(SELECT_HAVUZ_LIST, Tuple.class);
		List<Tuple> resultList = q.getResultList();

		for (Tuple tuple : resultList) {
			AkisHavuz dto = new AkisHavuz();
			dto.setAck((String) tuple.get("ACK"));
			dto.setPriorty(Integer.valueOf((String) tuple.get("PRIORTY")));
			dto.setCurrentHavuz(String.valueOf(tuple.get("CURRENT_HAVUZ")));

			responseList.add(dto);
		}

		return responseList;
	}

	@Override
	public List<commonDataDTO> getCommonDataList(Long depoId, Long projeId, Long projecDevreId, Long priorty) {
		List<commonDataDTO> responseList = new ArrayList<commonDataDTO>();

		Query q = entityManager.createNativeQuery(SELECT_DASHBOARD_DATA_WITH_PRIORTY, Tuple.class);
		q.setParameter(1, depoId);
		q.setParameter(2, projeId);
		q.setParameter(3, projecDevreId);
		q.setParameter(4, priorty);
		List<Tuple> resultList = q.getResultList();

		for (Tuple tuple : resultList) {
			commonDataDTO dto = new commonDataDTO();
			dto.setAgirlik((BigDecimal) tuple.get("AGIRLIK"));
			dto.setPriorty(String.valueOf(tuple.get("PRIORTY")));
			dto.setSpoolNo((String) tuple.get("SPOOLNO"));
			dto.setSanalBarkodNo(String.valueOf(tuple.get("SANALBARKOD")));
			dto.setHavuz(String.valueOf(tuple.get("HAVUZ")));
			dto.setDevreAdi(String.valueOf(tuple.get("DEVRE_ADI")));
			dto.setProjeAdi(String.valueOf(tuple.get("PROJE_ADI")));

			responseList.add(dto);
		}

		return responseList;
	}

	@Override
	public SanalBarkodResponse getSanalBarkodDetay(Long sanalBarkodNo) {

		SanalBarkodResponse response = new SanalBarkodResponse();

		Query q = entityManager.createNativeQuery(SELECT_BARKOD_DETAY);
		q.setParameter(1, sanalBarkodNo);
		Object[] result = (Object[]) q.getSingleResult();

		if (result.length > 0) {
			response.setSpoolNo(String.valueOf(result[0]));
			response.setDuzey(String.valueOf(result[1]));
			response.setDevreAdi(String.valueOf(result[2]));
		}

		return response;
	}
	

	@Override
	public List<GrafikOutputData>  getGrafikData(Long depoId,Long projeId,Long projecDevreId) {
		
		List<GrafikOutputData> responseList = new ArrayList<GrafikOutputData>();
		
		Query q = entityManager.createNativeQuery(SELECT_GRAFIK_DATA, Tuple.class);
		q.setParameter(1, projeId);
		q.setParameter(2, projecDevreId);
		
		List<Tuple> resultList = q.getResultList();

		for (Tuple tuple : resultList) {
			GrafikOutputData output=new GrafikOutputData();
			output.setIslemSayilari(new BigDecimal(tuple.get("ISLEMDURUMLARI").toString()));
			output.setHavuz(tuple.get("HAVUZ").toString());
			responseList.add(output);
		}
		
		return responseList;
	}

}