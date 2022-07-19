package com.disney.repositories.specifications;

import com.disney.dto.PersonajeFiltersDTO;
import com.disney.entities.PeliculaEntity;
import com.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeSpecification {

    public Specification<PersonajeEntity> getByFilters(String nombre, Integer edad, List<String> peliculas) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList();

            if (StringUtils.hasLength(nombre)) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + nombre.toLowerCase() + "%"
                        )
                );
            }
            if (edad != null){
                predicates.add(criteriaBuilder.equal(root.get("edad"), edad));
            }
            if (!CollectionUtils.isEmpty(peliculas)) {
                Join<PeliculaEntity, PersonajeEntity> join = root.join("peliculas", JoinType.INNER);
                Expression<String> peliculasId = join.get("id");
                predicates.add(peliculasId.in(peliculas));
            }

            //remove duplicates
            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
