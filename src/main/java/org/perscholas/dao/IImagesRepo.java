package org.perscholas.dao;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.perscholas.models.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagesRepo extends JpaRepository<Images,Long> {
}
