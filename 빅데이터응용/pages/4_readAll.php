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

        <div class="big-title">1. Calculate the percentage of all users' votes "by item" and organize them in order of large proportions.</div>
        <div class="semi-title">--> Use division of results, ROUND, GROUP BY, ORDER BY, Nested Query, View etc. (Advanced SQL 5)"</div>

        <div class="content"><div class="hard-to-naming">Item Name // Num of Votes // Total Count // ratio to the total</div>
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    $sql ="SELECT item_name, num, TOTAL, ROUND(num/TOTAL*100) as RATE FROM for_item_count";
                    $res = mysqli_query($mysqli, $sql);

                    if($res){
                        while($newArray = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $item_name = $newArray['item_name'];
                            $num = $newArray['num'];
                            $TOTAL = $newArray['TOTAL'];
                            $RATE = $newArray['RATE'];
                            echo("".$item_name."\t".$num."\t".$TOTAL."\t".$RATE."%<br/>");
                        }
                    }else{
                        //sql1쿼리 정상 작동 안함
                    }
                    mysqli_close($mysqli);
                }
            ?>
        </div>

        <div class="fora"><a href="4.html" style="text-decoration:none">Back</a></div>
    </body>
</html>