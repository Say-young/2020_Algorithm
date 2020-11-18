<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Travel Reduction</title>
        <link rel="stylesheet" href="../style/2.css">
    </head>
    <body>
        <header class = "header">
            <img id="header" src = "../img/2_white.png">
            <div class="stroke"></div>
            <div class="intro">Travel Reduction</div>
            <div class="intro">After Corona, how much has the travel rate decreased?</div>
        </header>

        <!--나라 이름, 나라마다 년도별로 최근 10년간 누적 방문자수-->
        <div class="big-title">1. The cumulative total of Korean visitors over 10 years "by country"</div>
        <div class="semi-title">--> Find the cumulative sum (Advanced SQL 2)</div>
        <div class="hard-to-naming">Country Name // Until When // Num of Visitors // Accumulate Sum</div>
        <div class="content">
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql ="SELECT country_name FROM country WHERE country_idx = '".$_POST['country']."'";
                    $res = mysqli_query($mysqli, $sql);
                    if($res){
                        while($newArray = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $country_name = $newArray['country_name'];
                            
                            $sql2 = "
                                SELECT t.country_name, t.visit_year as until_when, t.visitors,
                                    (SELECT SUM(x.visitors)
                                    FROM visitors_year_country x
                                    WHERE x.travel_idx <= t.travel_idx and x.country_name = '".$country_name."') AS accumulate_sum
                                FROM visitors_year_country t
                                WHERE t.country_name = '".$country_name."'";

                            $result = mysqli_query($mysqli, $sql2);
                            if($result){
                                while($newArray = mysqli_fetch_array($result,MYSQLI_ASSOC)){
                                    $country_name = $newArray['country_name'];
                                    $visit_year = $newArray['until_when'];
                                    $visitors = $newArray['visitors'];
                                    $accumulate_sum = $newArray['accumulate_sum'];
                                    echo("".$country_name."\t&nbsp//&nbsp\t".$visit_year."\t&nbsp//&nbsp\t".$visitors."\t&nbsp//&nbsp\t".$accumulate_sum."<br/>");
                                }
                            }else{
                            }
                        }
                    }else{
                        //sql1쿼리 정상 작동 안함
                    }
                    mysqli_close($mysqli);
                }
            ?>
        </div>
        
        <div class="middle_stroke"></div>

        <div class="big-title">2. The rate of decrease in the number of travelers in the country you choose</div>
        <div class="semi-title">--> The difference between the average number of travelers until 2019 <br/>and the number of travelers by 2020 was verified. (Advanced SQL 3)"</div>
        <div class="hard-to-naming">Country Name // Until 2019 AVG Num of Visitors // Num of Visitors in 2020 // reduction rate</div>
        <div class="content">
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql ="SELECT country_name FROM country WHERE country_idx = '".$_POST['country']."'";
                    $res = mysqli_query($mysqli, $sql);
                    if($res){
                        while($newArray = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $country_name = $newArray['country_name'];
                            $sql2 = "SELECT AVG(visitors) FROM visitors_year_country WHERE country_name = '".$country_name."' and visit_year <= 2019";
                            $sql3 = "SELECT count(visitors) FROM visitors_year_country WHERE country_name = '".$country_name."' and visit_year = 2020";
                            $result2 = mysqli_query($mysqli, $sql2);
                            $result3 = mysqli_query($mysqli, $sql3);
                                while($newArray = mysqli_fetch_array($result2,MYSQLI_ASSOC)){
                                    $avg = $newArray['AVG(visitors)'];
                                }

                                while($newArray = mysqli_fetch_array($result3,MYSQLI_ASSOC)){
                                    $now = $newArray['count(visitors)'];
                                }
                                $minus = ROUND(($avg-$now)/$avg*100);
                                echo("".$country_name."\t&nbsp//&nbsp\t".ROUND($avg,2)."\t&nbsp//&nbsp\t".$now."\t&nbsp//&nbsp\t".$minus."%<br/>");
                        }
                    }else{
                        //sql1쿼리 정상 작동 안함
                    }
                    mysqli_close($mysqli);
                }
            ?>
        </div>

    </body>
</html>