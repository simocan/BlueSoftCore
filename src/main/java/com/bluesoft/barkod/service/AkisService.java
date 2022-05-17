package com.bluesoft.barkod.service;

import java.util.List;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.entity.AkisHavuzPersonel;
import com.bluesoft.barkod.entity.TblDepo;

public interface AkisService {

	public AkisHavuz getAkisHavuz(String havuz);

	public List<AkisHavuz> getAkisHavuzListByState(String state);

	public List<AkisHavuz> getAkisHavuzListByPriorty(int priorty);

	public List<AkisHavuz> getAkisHavuzList();
	
	public List<AkisHavuzPersonel> getAkisHavuzPersonelListByPersonel(int personelId,List<String> havuzList);
	
	public List<AkisHavuz> getAkisHavuzList(List<String> havuzList);
	
	public TblDepo getDepoList(Long depoId);

}