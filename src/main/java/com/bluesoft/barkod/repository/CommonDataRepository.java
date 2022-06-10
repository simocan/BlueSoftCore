package com.bluesoft.barkod.repository;

import java.util.List;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.model.GrafikOutputData;
import com.bluesoft.barkod.model.SanalBarkodResponse;
import com.bluesoft.barkod.model.commonDataDTO;


public interface CommonDataRepository {

	List<commonDataDTO> getCommonDataList(Long depoId,Long projeId,Long projecDevreId);
	
	List<AkisHavuz> getHavuzList();
	
	List<commonDataDTO> getCommonDataList(Long depoId,Long projeId,Long projecDevreId,Long priorty);
	
	public SanalBarkodResponse getSanalBarkodDetay(Long sanalBarkodNo);
	
	public List<GrafikOutputData> getGrafikData(Long depoId,Long projeId,Long projecDevreId);

}
