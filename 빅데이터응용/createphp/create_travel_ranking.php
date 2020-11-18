<?php
    $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

    if(mysqli_connect_error()){
        prinf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }else{
        $sql = "
            CREATE TABLE `team16`.`travel_ranking` (
                `travel_idx` INT NOT NULL AUTO_INCREMENT,
                `country_idx` INT NOT NULL,
                `visit_year` VARCHAR(10) NOT NULL,
                PRIMARY KEY (`travel_idx`),
                CONSTRAINT `country_travel_idx`
                FOREIGN KEY (`country_idx`)
                REFERENCES `team16`.`country` (`country_idx`)
                ON DELETE CASCADE
                ON UPDATE CASCADE);
          ";

        $res = mysqli_query($mysqli, $sql);
        
        if($res === TRUE){
            echo "travel_ranking Table is are succesfully created.";
        }else{
            printf("Could not create table: %s\n", mysqli_error($mysqli));
        }
        
        mysqli_close($mysqli);
    }
?>