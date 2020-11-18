<?php
    $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

    if(mysqli_connect_error()){
        prinf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }else{
        $sql = "
            CREATE TABLE `team16`.`must_have_items` (
                `item_idx` INT NOT NULL AUTO_INCREMENT,
                `user_idx` INT NOT NULL,
                `item_name` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`item_idx`),
                CONSTRAINT `user_idx`
                FOREIGN KEY (`user_idx`)
                REFERENCES `team16`.`user` (`user_idx`)
                ON DELETE CASCADE
                ON UPDATE CASCADE);
          ";

        $res = mysqli_query($mysqli, $sql);
        
        if($res === TRUE){
            echo "must_have_items Table is succesfully created.";
        }else{
            printf("Could not create table: %s\n", mysqli_error($mysqli));
        }
        
        mysqli_close($mysqli);
    }
?>