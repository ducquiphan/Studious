
package com.studious.DAO;

import java.util.List;

/**
 *
 * @author NGUYEN VAN SI
 */
public abstract class StudiousDAO <EntityType, KeyType> {
    public abstract void insert(EntityType entity);
    public abstract void update(EntityType entity);
    public abstract void delete(KeyType key);
    public abstract List<EntityType> selectAll();
    public abstract EntityType selectById(KeyType key);
    public abstract List<EntityType> selectSql(String Sql, Object... args);
}