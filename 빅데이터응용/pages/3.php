<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Wish-Listed Destinations</title>
        <link rel="stylesheet" href="../style/3.css">
    </head>
    <body>
        <header class = "header">
            <img id="header" src = "../img/3_white.png">
            <div class="stroke"></div>
            <div class="intro">Wish-Listed Destinations</div>
            <div class="intro">Where do you want to travel most after end of Pandamic?</div>
        </header>

        <!--이곳에는 사용자가 입력한 값을 기존 데이터에 더해 나라별/대륙별로 묶어서 랭킹을 보여줍니다.-->
        <?php
            $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

            if(mysqli_connect_error()){
                prinf("Connect failed: %s\n", mysqli_connect_error());
                exit();
            }else{
                $sql = "INSERT INTO `team16`.`wanna_travel_places` (`country_idx`) VALUES ('".$_POST['country']."')";
                $res = mysqli_query($mysqli, $sql);
                if($res === TRUE){
                }else{
                    printf("Data was not inserted.");
                }
                mysqli_close($mysqli);
            }
        ?>

        <div class="big-title">Finding the country that people want to visit the most</div>
        <div class="semi-title">--> Find the ranking by using "Rank (Advanced SQL 4)"</div>

        <div class="title">1. Group by Continent</div>
        <div class="continent_rank"> <div class="tiny-hard-to-naming">Ranking</div>
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql = "
                        SELECT (1 + (select count(*) from wish_rank_by_continent B where B.visitors > A.visitors)) as ranking
                        FROM wish_rank_by_continent A ORDER BY ranking";
                    $res = mysqli_query($mysqli, $sql);

                    /*
                        테이블의 row 개수만큼 아래가 반복됨
                        while($newArray = mysqli_fetch_array($res,MYSQLI_ASSOC))
                    */

                    if($res){
                        while($result = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $rank = $result['ranking'];
                            echo "".$rank."\n";
                        }
                    }else{
                        printf("Could not retrieve records: %s\n", mysqli_error($mysqli));
                    }

                    mysqli_free_result($res);
                    mysqli_close($mysqli);
                }
            ?>
        </div>
        <div class="continent_name"> <div class="tiny-hard-to-naming">Continent Name</div>
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql = "SELECT country_continent from wish_rank_by_continent order by visitors desc";
                    $res = mysqli_query($mysqli, $sql);

                    if($res){
                        while($result = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $name = $result['country_continent'];
                            echo "".$name."\n";
                        }
                    }else{
                        printf("Could not retrieve records: %s\n", mysqli_error($mysqli));
                    }

                    mysqli_free_result($res);
                    mysqli_close($mysqli);
                }
            ?>
        </div>
        <div class="continent_visitors"> <div class="tiny-hard-to-naming">Num of Voters</div>
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql = "SELECT visitors from wish_rank_by_continent order by visitors desc";
                    $res = mysqli_query($mysqli, $sql);

                    if($res){
                        while($result = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $visitors = $result['visitors'];
                            echo "".$visitors."\n";
                        }
                    }else{
                        printf("Could not retrieve records: %s\n", mysqli_error($mysqli));
                    }

                    mysqli_free_result($res);
                    mysqli_close($mysqli);
                }
            ?>
        </div>

        <div class="middle_stroke"></div>
        <div class="title">2. Group by Country</div>
        <div class="country_result"> <div class="hard-to-naming">Rank // Country Name // Num of Voters</div>
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql = "
                            SELECT country_name, (1 + (select count(*) from wish_rank_by_country B where B.visitors > A.visitors)) as ranking, visitors
                            FROM wish_rank_by_country A ORDER BY ranking;";
                    $res = mysqli_query($mysqli, $sql);

                    /*
                        테이블의 row 개수만큼 아래가 반복됨
                        while($newArray = mysqli_fetch_array($res,MYSQLI_ASSOC))
                    */

                    if($res){
                        echo "<br/>";
                        while($result = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $rank = $result['ranking'];
                            $country = $result['country_name'];
                            $visitors = $result['visitors'];
                            echo "".$rank."\t";
                            echo "".$country."\t";
                            echo "".$visitors."<br/>";
                        }
                    }else{
                        printf("Could not retrieve records: %s\n", mysqli_error($mysqli));
                    }

                    mysqli_free_result($res);
                    mysqli_close($mysqli);
                }
            ?>
        </div>

        </body>
    <script src="script.js"></script>
</html>