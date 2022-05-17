package com.bluesoft.barkod.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bluesoft.barkod.entity.Proje;
import com.bluesoft.barkod.entity.ProjeDevre;
import com.bluesoft.barkod.repository.ProjeRepository;

@Repository
public class ProjeRepositoryImpl implements ProjeRepository {

	@PersistenceContext
	private EntityManager entityManager;


	@Transactional
	@Override
	public List<Proje> getProjectList(Long depoId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Proje> cq = cb.createQuery(Proje.class);

		Root<Proje> proje = cq.from(Proje.class);

		Predicate authorNamePredicate = cb.equal(proje.get("depoId"), depoId);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getResultList();
	}


	@Override
	public List<ProjeDevre> getProjectDevreList(int projeId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProjeDevre> cq = cb.createQuery(ProjeDevre.class);

		Root<ProjeDevre> proje = cq.from(ProjeDevre.class);

		Predicate authorNamePredicate = cb.equal(proje.get("projeId"), projeId);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getResultList();
	}


}
