package com.bluesoft.barkod.service;

import java.util.List;

import com.bluesoft.barkod.entity.Proje;
import com.bluesoft.barkod.entity.ProjeDevre;

public interface ProjectService {

	List<Proje> getProjectList(Long depoId);
	
	List<ProjeDevre> getProjectDevreList(int projeId);

}