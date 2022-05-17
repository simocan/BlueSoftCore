package com.bluesoft.barkod.service;

import java.util.List;

import com.bluesoft.barkod.entity.TblSanalBarkod;

public interface SanalBarkodService {

	public List<TblSanalBarkod> getSanalBarkodList(String sanalBarkodNo);
	
	public TblSanalBarkod getSanalBarkod(String sanalBarkodNo);
	
	public int update(String sanalBarkodNo,int personelId,String havuz);


}