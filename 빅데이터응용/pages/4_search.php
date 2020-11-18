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

        <div class="title"><div class="hard-to-naming">item name // num of voters</div>
            <?php
                $mysqli = mysqli_connect("localhost", "team16", "team16", "team16");

                if(mysqli_connect_error()){
                    prinf("Connect failed: %s\n", mysqli_connect_error());
                    exit();
                }else{
                    /*
                    $sql = "SELECT item_name, COUNT(*) FROM must_have_items group by item_name order by count(*) desc";
                    */
                    $sql ="SELECT * FROM must_have_items WHERE item_name = '".$_POST['item_name_search']."'";
                    $res = mysqli_query($mysqli, $sql);

                    if($res){
                        echo("<br/>");
                        while($newArray = mysqli_fetch_array($res,MYSQLI_ASSOC)){
                            $item_name = $newArray['item_name'];

                            $sql2 = "SELECT COUNT(*) FROM must_have_items WHERE item_name = '".$item_name."'";
                            $result = mysqli_query($mysqli, $sql2);

                            if($result){
                                while($newArray2 = mysqli_fetch_array($result,MYSQLI_ASSOC)){
                                    $count = $newArray2['COUNT(*)'];
                                }
                            }else{

                            }
                        }
                        echo("".$item_name."\t".$count."<br/>");
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