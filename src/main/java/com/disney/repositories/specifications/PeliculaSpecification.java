package com.disney.repositories.specifications;


import com.disney.dto.PeliculaFiltersDTO;
import com.disney.entities.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSpecification {

    public Specification<PeliculaEntity> getByFilters(PeliculaFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList();

            if (StringUtils.hasLength(filtersDTO.getTitulo())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getTitulo().toLowerCase() + "%"
                        )
                );
            }

            /*if (!CollectionUtils.isEmpty(filtersDTO.getGenero())) {
                Join<PaisEntity, IconEntity> join = root.join("paises", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add(citiesId.in(filtersDTO.getCities()));
            }*/

            // Remove duplicates
            query.distinct(true);

            // Order resolver
            String orderByField = "fechaCreacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
