package com.entity;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Assignment entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.entity.Assignment
 * @author MyEclipse Persistence Tools
 */

public class AssignmentDAO implements IAssignmentDAO {
	// property constants
	public static final String ASSIGNMENT_NAME = "assignmentName";
	public static final String SUBMIT_COUNT = "submitCount";
	public static final String ASSIGNMENT_DESCRIBE = "assignmentDescribe";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Assignment entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * AssignmentDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Assignment entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Assignment entity) {
		EntityManagerHelper.log("saving Assignment instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Assignment entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * AssignmentDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Assignment entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Assignment entity) {
		EntityManagerHelper.log("deleting Assignment instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Assignment.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Assignment entity and return it or a copy of
	 * it to the sender. A copy of the Assignment entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = AssignmentDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Assignment entity to update
	 * @return Assignment the persisted Assignment entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Assignment update(Assignment entity) {
		EntityManagerHelper.log("updating Assignment instance", Level.INFO,
				null);
		try {
			Assignment result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Assignment findById(Integer id) {
		EntityManagerHelper.log("finding Assignment instance with id: " + id,
				Level.INFO, null);
		try {
			Assignment instance = getEntityManager().find(Assignment.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Assignment entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Assignment property to query
	 * @param value
	 *            the property value to match
	 * @return List<Assignment> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Assignment> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Assignment instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Assignment model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<Assignment> findByAssignmentName(Object assignmentName) {
		return findByProperty(ASSIGNMENT_NAME, assignmentName);
	}

	public List<Assignment> findBySubmitCount(Object submitCount) {
		return findByProperty(SUBMIT_COUNT, submitCount);
	}

	public List<Assignment> findByAssignmentDescribe(Object assignmentDescribe) {
		return findByProperty(ASSIGNMENT_DESCRIBE, assignmentDescribe);
	}

	/**
	 * Find all Assignment entities.
	 * 
	 * @return List<Assignment> all Assignment entities
	 */
	@SuppressWarnings("unchecked")
	public List<Assignment> findAll() {
		EntityManagerHelper.log("finding all Assignment instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Assignment model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}