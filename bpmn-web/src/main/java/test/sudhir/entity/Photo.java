package test.sudhir.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author sudhir
 *         Date:7/11/16
 *         Time:5:39 PM
 *         Project:demo
 */
@Entity
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue
        private Long id;

        private String userId;

        private boolean processed;

        public boolean isProcessed() {
            return processed;
        }

        public Long getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        // jpa
        Photo() {
        }

        public Photo(String userId) {
            this.userId = userId;
        }

        public Photo(String userId, boolean processed) {
            this.userId = userId;
            this.processed = processed;
        }
    }

