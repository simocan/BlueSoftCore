package com.bluesoft.barkod.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bluesoft.barkod.entity.TblSanalBarkod;
import com.bluesoft.barkod.repository.SanalBarkodRepository;

@Repository
public class SanalBarkodRepositoryImpl implements SanalBarkodRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Override
	public List<TblSanalBarkod> getSanalBarkodList(String sanalBarkodNo) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<TblSanalBarkod> cq = cb.createQuery(TblSanalBarkod.class);

		Root<TblSanalBarkod> sanalBarkod = cq.from(TblSanalBarkod.class);

		Predicate authorNamePredicate = cb.equal(sanalBarkod.get("sanalBakod"), sanalBarkodNo);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public TblSanalBarkod getSanalBarkod(String sanalBarkodNo) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<TblSanalBarkod> cq = cb.createQuery(TblSanalBarkod.class);

		Root<TblSanalBarkod> sanalBarkod = cq.from(TblSanalBarkod.class);

		Predicate authorNamePredicate = cb.equal(sanalBarkod.get("sanalBarkod"), sanalBarkodNo);
		cq.where(authorNamePredicate);

		return entityManager.createQuery(cq).getSingleResult();
	}

	@Transactional
	@Modifying
	@Override
	public int update(String sanalBarkodNo, int personelId, String havuz) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaUpdate<TblSanalBarkod> update = cb.createCriteriaUpdate(TblSanalBarkod.class);
		
		// set the root class
		Root e = update.from(TblSanalBarkod.class);
		
		Predicate predicateUpdate= cb.equal(e.get("sanalBarkod"), sanalBarkodNo);

		// set update and where clause
		update.set("personelId", personelId);
		update.set("havuz", havuz);
		update.set("tarih", new Date());
		update.where(predicateUpdate);
		
		return entityManager.createQuery(update).executeUpdate();
	}

}
