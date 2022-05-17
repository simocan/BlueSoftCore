package com.bluesoft.barkod.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.entity.AkisHavuzPersonel;
import com.bluesoft.barkod.entity.TblDepo;
import com.bluesoft.barkod.repository.AkisHavuzRepository;
import com.bluesoft.barkod.service.AkisService;

@Service
public class AkisHavuzServiceImpl implements AkisService {

	@Autowired
	private AkisHavuzRepository akisHavuzRepository;

	@Override
	public AkisHavuz getAkisHavuz(String havuz) {
		return akisHavuzRepository.getAkisHavuz(havuz);
	}

	@Override
	public List<AkisHavuz> getAkisHavuzListByState(String state) {
		return akisHavuzRepository.getAkisHavuzListByState(state);
	}

	@Override
	public List<AkisHavuz> getAkisHavuzListByPriorty(int priorty) {
		return akisHavuzRepository.getAkisHavuzListByPriorty(priorty);
	}

	@Override
	public List<AkisHavuz> getAkisHavuzList() {
		return akisHavuzRepository.getAkisHavuzList();
	}

	@Override
	public List<AkisHavuzPersonel> getAkisHavuzPersonelListByPersonel(int personelId,List<String> havuzList) {
		return akisHavuzRepository.getAkisHavuzPersonelListByPersonel(personelId,havuzList);
	}

	@Override
	public List<AkisHavuz> getAkisHavuzList(List<String> havuzList) {
		return akisHavuzRepository.getAkisHavuzList(havuzList);
	}

	@Override
	public TblDepo getDepoList(Long depoId) {
		return akisHavuzRepository.getDepoList(depoId);
	}

}
