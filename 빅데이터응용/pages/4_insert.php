<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Travel Essential Items</title>
        <link rel="stylesheet" href="../style/4.css">
    </head>
    <body>
        <header class = "header">
            <img id="header" src = "../img/4_white.png">
            <div class="stroke"></div>
            <div class="intro">Travel Essential Items</div>
            <div class="intro">What are the must-have items for traveling?</div>
        </header>

        <div class="title">
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql1 = "SELECT * FROM user WHERE user_name = '".$_POST['user_name']."' and user_password = '".$_POST['user_password']."'";
                    $res = mysqli_query($mysqli, $sql1);

                    if($res){
                        $num = mysqli_num_rows($res);
                        if($num == 1){
                            //이미 사용한 계정
                            echo("Cannot try to insert with already use Account.");
                        }else{
                            //계정 생성
                            $sql2 = "INSERT INTO `team16`.`user` (`user_name`, `user_password`) VALUES ('".$_POST['user_name']."', '".$_POST['user_password']."')";
                            $signup = mysqli_query($mysqli, $sql2);

                            if($signup === TRUE){
                                $sql3 = "SELECT * FROM user WHERE user_name = '".$_POST['user_name']."' and user_password = '".$_POST['user_password']."'";
                                $check = mysqli_query($mysqli, $sql3);

                                if($check){
                                    while($newArray = mysqli_fetch_array($check,MYSQLI_ASSOC)){
                                        $idx = $newArray['user_idx'];
                                        //여기서 회원가입 완료 - user_idx 반환

                                        $sql4 = "INSERT INTO `team16`.`must_have_items` (`user_idx`, `item_name`) VALUES ('".$idx."', '".$_POST['user_item']."')";
                                        $insert = mysqli_query($mysqli, $sql4);

                                        if($insert === TRUE){
                                            echo("I used Transaction here. Your data is inserted Successfully.");
                                        }else{
                                            //must-have-item insert fail
                                        }
                                    }
                                }else{
                                    //sql3 정상 작동 안함
                                }
                            }else{
                                //sql2 정상 작동 안함
                            }
                        }
                    }else{
                        //sql1쿼리 정상 작동 안함
                    }
                    //
                    mysqli_close($mysqli);
                }
            ?>
        </div>
        <div class="fora"><a href="4.html" style="text-decoration:none">Back</a></div>
    </body>
</html>