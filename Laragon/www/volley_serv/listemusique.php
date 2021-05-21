<?php
    $serverName = "DESKTOP-AVI6ACP\SQLEXPRESS"; 
    $connectionInfo = array( "Database"=>"Musiquebdd", "UID"=>"antooo", "PWD"=>"antooo123","CharacterSet"=> "UTF-8");
    $cnx = sqlsrv_connect( $serverName, $connectionInfo);

    function getListeMusique()
    {
        global $cnx;
        $sql = "SELECT Titre, Album, Img, nom_Auteur, libelle, Lien
        FROM Musique, Genre, Auteur
        WHERE Musique.idAuteur = Auteur.idAuteur
        AND Musique.idGenre = Genre.idGenre";
        $stmt = sqlsrv_query( $cnx, $sql);
        if( $stmt === false ) {
            die( print_r( sqlsrv_errors(), true));
        }

        $result = array();
        do {
            while ($row = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_ASSOC)) {
                $result[] = $row;
            }
            }
            while (sqlsrv_next_result($stmt));
        return $result;
    }

    echo json_encode(getListeMusique(), JSON_UNESCAPED_UNICODE);
?>