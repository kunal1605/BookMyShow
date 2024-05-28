    package org.example.bookmyshow.models;

    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.MappedSuperclass;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.Date;



    //Provided by Lombok
    @Getter
    @Setter
    //@NoArgsConstructor
    //@AllArgsConstructor
    @MappedSuperclass   //I want all the propery of the base class to be will inherited class
    // so this annotation is needed
    public class BaseModel  {
@Id  //This tells us we want this prop to be the primary key
      @GeneratedValue(strategy = GenerationType.IDENTITY)
//What strategy to be used in generation of the id
        private Long id;

        private Date updatedDate;
        private Date createdDate;
    }