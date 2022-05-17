package com.bluesoft.barkod.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bluesoft.barkod.entity.UserEntity;
import com.bluesoft.barkod.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;


	@Transactional
	@Override
	public Optional<UserEntity> findByUsername(String username) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);

		Root<UserEntity> user = cq.from(UserEntity.class);

		Predicate authorNamePredicate = cb.equal(user.get("username"), username);
		Predicate aktifPredicate = cb.equal(user.get("aktif"), "1");
		cq.where(authorNamePredicate,aktifPredicate);

		return Optional.of(entityManager.createQuery(cq).getSingleResult());

	}

	@Transactional
	@Override
	public Boolean existsByUsername(String username) {
		return findByUsername(username).isPresent();
	}

	@Transactional
	@Override
	public Optional<UserEntity> findById(Long id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);

		Root<UserEntity> user = cq.from(UserEntity.class);

		Predicate authorNamePredicate = cb.equal(user.get("id"), id);
		Predicate aktifPredicate = cb.equal(user.get("aktif"), "1");
		cq.where(authorNamePredicate,aktifPredicate);

		return Optional.of(entityManager.createQuery(cq).getSingleResult());
	}

	@Override
	public Optional<UserEntity> findByNameAndPassword(String username, String password) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);

		Root<UserEntity> user = cq.from(UserEntity.class);

		Predicate authorNamePredicate = cb.equal(user.get("username"), username);
		Predicate authorPasswordPredicate = cb.equal(user.get("password"), password);
		Predicate aktifPredicate = cb.equal(user.get("aktif"), "1");
		cq.where(authorNamePredicate,authorPasswordPredicate,aktifPredicate);

		return Optional.of(entityManager.createQuery(cq).getSingleResult());
	}

}
