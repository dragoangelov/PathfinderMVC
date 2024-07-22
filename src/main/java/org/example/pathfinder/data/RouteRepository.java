package org.example.pathfinder.data;

import org.example.pathfinder.model.CategoryType;
import org.example.pathfinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findAllByCategories_Name(CategoryType categoryType);

}
