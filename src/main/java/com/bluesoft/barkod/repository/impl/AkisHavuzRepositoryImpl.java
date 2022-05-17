package com.bluesoft.barkod.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bluesoft.barkod.entity.AkisHavuz;
import com.bluesoft.barkod.entity.AkisHavuzPersonel;
import com.bluesoft.barkod.entity.AkisProgress;
import com.bluesoft.barkod.entity.TblDepo;
import com.bluesoft.barkod.repository.AkisHavuzRepository;

@Repository
public class AkisHavuzRepositoryImpl implements AkisHavuzRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AkisHavuz getAkisHavuz(String havuz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AkisHavuz> cq = cb.createQuery(AkisHavuz.class);

		Root<AkisHavuz> akisHavuz = cq.from(AkisHavuz.class);

		Predicate authorNamePredicate = cb.equal(akisHavuz.get("name"), havuz);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getSingleResult();
	}

	@Override
	public List<AkisHavuz> getAkisHavuzListByState(String state) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AkisHavuz> cq = cb.createQuery(AkisHavuz.class);

		Root<AkisHavuz> akisHavuz = cq.from(AkisHavuz.class);

		Predicate authorNamePredicate = cb.equal(akisHavuz.get("state"), state);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<AkisHavuz> getAkisHavuzListByPriorty(int priorty) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AkisHavuz> cq = cb.createQuery(AkisHavuz.class);

		Root<AkisHavuz> akisHavuz = cq.from(AkisHavuz.class);

		Predicate authorNamePredicate = cb.equal(akisHavuz.get("priorty"), priorty);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<AkisHavuz> getAkisHavuzList() {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AkisHavuz> query = builder.createQuery(AkisHavuz.class);
		Root<AkisHavuz> variableRoot = query.from(AkisHavuz.class);
		query.select(variableRoot);

		return entityManager.createQuery(query).getResultList();

	}

	@Override
	public List<AkisHavuzPersonel> getAkisHavuzPersonelListByPersonel(int personelId, List<String> havuzList) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AkisHavuzPersonel> cq = cb.createQuery(AkisHavuzPersonel.class);

		Root<AkisHavuzPersonel> akisHavuz = cq.from(AkisHavuzPersonel.class);

		Predicate authorNamePredicate = cb.equal(akisHavuz.get("personelId"), personelId);
		Predicate havuzPredicate = cb.isTrue(akisHavuz.get("havuz").in(havuzList));
		cq.where(authorNamePredicate, havuzPredicate);

		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<AkisHavuz> getAkisHavuzList(List<String> havuzList) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AkisHavuz> cq = cb.createQuery(AkisHavuz.class);

		Root<AkisHavuz> akisHavuz = cq.from(AkisHavuz.class);

		Predicate havuzPredicate = cb.isTrue(akisHavuz.get("name").in(havuzList));
		cq.where(havuzPredicate);

		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	@Modifying
	public int insertAkisProgres(AkisProgress akisProgress) {
		 this.entityManager.persist(akisProgress);
		 return 1;
	}

	@Override
	public TblDepo getDepoList(Long depoId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<TblDepo> cq = cb.createQuery(TblDepo.class);

		Root<TblDepo> depo = cq.from(TblDepo.class);

		Predicate authorNamePredicate = cb.equal(depo.get("id"), depoId);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getSingleResult();
	}

}