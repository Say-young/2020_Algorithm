<?php
    $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

    if(mysqli_connect_error()){
        prinf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }else{
        $sql = "
            CREATE TABLE `team16`.`country` (
                `country_idx` INT NOT NULL AUTO_INCREMENT,
                `country_continent` VARCHAR(45) NOT NULL,
                `country_name` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`country_idx`));
          ";

        $res = mysqli_query($mysqli, $sql);
        
        if($res === TRUE){
            echo "Country Table is succesfully created.";
        }else{
            printf("Could not create table: %s\n", mysqli_error($mysqli));
        }
        
        mysqli_close($mysqli);
    }
?>