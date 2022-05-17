package com.bluesoft.barkod.repository.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.bluesoft.barkod.entity.TblSanalBarkod;
import com.bluesoft.barkod.entity.TblStokHareket;
import com.bluesoft.barkod.repository.MobilUserActionRepository;

@Repository
public class MobilUserActionRepositoryImpl implements MobilUserActionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@Modifying
	@Override
	public int userActions(String sanalBarkodNo, Long userId, List<TblSanalBarkod> sanalBakodList) {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaUpdate<TblStokHareket> update = cb.createCriteriaUpdate(TblStokHareket.class);

		// set the root class
		Root e = update.from(TblStokHareket.class);

		// set update and where clause
		update.set("islemTipi", 2);
		update.set("onImalatUser", userId);
		update.set("onImalatDate", new Date());
		update.where(e.get("spoolNo").in(sanalBakodList.stream().map(TblSanalBarkod::getSpoolNo).collect(Collectors.toList())));
		
		return entityManager.createQuery(update).executeUpdate();
	}


}
