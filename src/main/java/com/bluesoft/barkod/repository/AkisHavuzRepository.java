package com.bluesoft.barkod.repository;

import java.util.List;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.entity.AkisHavuzPersonel;
import com.bluesoft.barkod.entity.AkisProgress;
import com.bluesoft.barkod.entity.TblDepo;

public interface AkisHavuzRepository {

	public AkisHavuz getAkisHavuz(String havuz);

	public List<AkisHavuz> getAkisHavuzListByState(String state);

	public List<AkisHavuz> getAkisHavuzListByPriorty(int priorty);
	
	public List<AkisHavuz> getAkisHavuzList();
	
	public List<AkisHavuzPersonel> getAkisHavuzPersonelListByPersonel(int personelId,List<String> havuzList);

	public List<AkisHavuz> getAkisHavuzList(List<String> havuzList);
	
	public int insertAkisProgres(AkisProgress akisProgress);
	
	public TblDepo getDepoList(Long depoId);
	
	
}
