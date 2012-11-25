package com.entity;

import java.util.Date;
import java.util.List;

/**
 * Interface for AssignmentDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IAssignmentDAO {
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
	 * IAssignmentDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Assignment entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Assignment entity);

	/**
	 * Delete a persistent Assignment entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAssignmentDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Assignment entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Assignment entity);

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
	 * entity = IAssignmentDAO.update(entity);
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
	public Assignment update(Assignment entity);

	public Assignment findById(Integer id);

	/**
	 * Find all Assignment entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Assignment property to query
	 * @param value
	 *            the property value to match
	 * @return List<Assignment> found by query
	 */
	public List<Assignment> findByProperty(String propertyName, Object value);

	public List<Assignment> findByAssignmentName(Object assignmentName);

	public List<Assignment> findBySubmitCount(Object submitCount);

	public List<Assignment> findByAssignmentDescribe(Object assignmentDescribe);

	/**
	 * Find all Assignment entities.
	 * 
	 * @return List<Assignment> all Assignment entities
	 */
	public List<Assignment> findAll();
}