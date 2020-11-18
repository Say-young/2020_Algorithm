<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Travel Ranking</title>
        <link rel="stylesheet" href="../style/1.css">
    </head>
    <body>
        <header class = "header">
            <img id="header" src = "../img/1_white.png">
            <div class="stroke"></div>
            <div class="intro">Travel Ranking</div>
            <div class="intro">Before Corona, which country did Koreans travel the most?</div>
        </header>

        <!--여기에 나라 이름, 나라별(group by) 최근 10년간 총 방문자 수(sum), 1년 평균 방문자 수(avg), 방문 ranking 들어갑니다요-->
        <div class="title">1. Number of Korean Travelers in the Last 10 Years "by Country"</div>
        <div class="semi-title">--> Find the sum total of all visitors by using "RollUp (Advanced SQL 1)"</div>
        <div class="content">
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql ="SELECT country_idx, SUM(visit_flag) total_visitors FROM travel_ranking GROUP BY country_idx with rollup";
                    $res = mysqli_query($mysqli, $sql);

                    if($res){
                        while($newArray = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $country_idx = $newArray['country_idx'];
                            $sum = $newArray['total_visitors'];
                            
                            $sql2 = "SELECT country_name FROM country WHERE country_idx = '".$country_idx."'";
                            $result = mysqli_query($mysqli, $sql2);
                            if($result){
                                if($country_idx){
                                    while($newArray = mysqli_fetch_array($result,MYSQLI_ASSOC)){
                                        $country_name = $newArray['country_name'];
                                        echo("".$country_name."\t".$sum."<br/>");
                                    }
                                }else{
                                }
                            }else{
                            }
                        }
                        echo("NUM OF TOTAL PARTICIPANTS : ".$sum."");
                    }else{
                        //sql1쿼리 정상 작동 안함
                    }
                    mysqli_close($mysqli);
                }
            ?>
        </div>
    </body>
</html>