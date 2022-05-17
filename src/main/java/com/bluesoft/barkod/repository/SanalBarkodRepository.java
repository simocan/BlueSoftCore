package com.bluesoft.barkod.repository;

import java.util.List;

import com.bluesoft.barkod.entity.TblSanalBarkod;


public interface SanalBarkodRepository {

	
	List<TblSanalBarkod> getSanalBarkodList(String sanalBarkodNo);
	
	public TblSanalBarkod getSanalBarkod(String sanalBarkodNo);
	
	public int update(String sanalBarkodNo,int personelId,String havuz);

}
