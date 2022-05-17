package com.bluesoft.barkod.repository;

import java.util.List;

import com.bluesoft.barkod.entity.Proje;
import com.bluesoft.barkod.entity.ProjeDevre;


public interface ProjeRepository {

	List<Proje> getProjectList(Long depoId);

	List<ProjeDevre> getProjectDevreList(int projeId);

}
