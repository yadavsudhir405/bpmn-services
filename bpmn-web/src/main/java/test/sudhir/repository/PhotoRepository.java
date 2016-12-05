package test.sudhir.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import test.sudhir.entity.Photo;

/**
 * @author sudhir
 *         Date:7/11/16
 *         Time:5:42 PM
 *         Project:demo
 */

public interface PhotoRepository extends JpaRepository<Photo,Long>{

}
