package com.bluesoft.barkod.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesoft.barkod.entity.TblSanalBarkod;
import com.bluesoft.barkod.repository.SanalBarkodRepository;
import com.bluesoft.barkod.service.SanalBarkodService;

@Service
public class SanalBarkodServiceImpl implements SanalBarkodService {

	@Autowired
	private SanalBarkodRepository sanalBarkodRepository;


	@Override
	public List<TblSanalBarkod> getSanalBarkodList(String sanalBarkodNo) {
		return sanalBarkodRepository.getSanalBarkodList(sanalBarkodNo);
	}


	@Override
	public TblSanalBarkod getSanalBarkod(String sanalBarkodNo) {
		return sanalBarkodRepository.getSanalBarkod(sanalBarkodNo);
	}


	@Override
	public int update(String sanalBarkodNo, int personelId, String havuz) {
		return sanalBarkodRepository.update(sanalBarkodNo, personelId, havuz);
	}


}
