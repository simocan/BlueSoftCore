package com.bluesoft.barkod.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesoft.barkod.entity.Proje;
import com.bluesoft.barkod.entity.ProjeDevre;
import com.bluesoft.barkod.repository.ProjeRepository;
import com.bluesoft.barkod.service.ProjectService;

@Service
public class ProjeServiceImpl implements ProjectService {

	@Autowired
	private ProjeRepository projeRepository;

	@Override
	public List<Proje> getProjectList(Long depoId) {
		return projeRepository.getProjectList(depoId);
	}

	@Override
	public List<ProjeDevre> getProjectDevreList(int projeId) {
		return projeRepository.getProjectDevreList(projeId);
	}


}
