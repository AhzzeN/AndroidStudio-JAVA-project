<?php

    class Connexion 
    {
        public static function connectMSSQL(){
            //***************** SQL Server *****************//
            //identifiants pour la base de données SQL Server
            $SQL_DNS ="sqlsrv:Server=DESKTOP-AVI6ACP\SQLEXPRESS,1433;Database=Musiquebdd";
            $SQL_USERNAME = "antooo";
            $SQL_PASSWORD = "antooo123";
        
            $attributs = array(
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::SQLSRV_ATTR_ENCODING => PDO::SQLSRV_ENCODING_SYSTEM);
            try{
                $cnx = new PDO($SQL_DNS, $SQL_USERNAME, $SQL_PASSWORD);
            }
            catch(Exception $e){
                echo ($e->getMessage());
            }
            return $cnx;
        }
    }
?>