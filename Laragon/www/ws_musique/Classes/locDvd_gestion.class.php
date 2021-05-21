<?php

include_once ('connexion.class.php');

class locDVD_gestion
{
    private $cnx;

    public function __construct(){
        $this->cnx = Connexion::connectMSSQL();
    }

    public function userExist($email)
    {
        $sql = "SELECT * FROM users WHERE email = ?";
        $stmt = $this->cnx->prepare($sql);
        $stmt->bindParam(1, $email, PDO::PARAM_STR);
        $stmt->execute();
        $result = $stmt->fetchAll();
        return count($result)>0;
    }

    public function addUser($email, $password)
    {
        if($this->userExist($email)){
            return 0;
        }
        else 
        {
            if ($email !="" && $password !="")
            {
                $paswd = password_hash($password, PASSWORD_DEFAULT);
                $sql = "INSERT INTO users (email, password) VALUES (?, ?)";
                $stmt = $this->cnx->prepare($sql);
                $stmt->bindParam(1, $email, PDO::PARAM_STR);
                $stmt->bindParam(2, $paswd, PDO::PARAM_STR);
                if($stmt->execute()){
                    return 1;
                }
            }
            else
            {
            return 2;
            }
        }
    }

    public function loginUser($email, $password){
        if($user = $this->getUserByEmail($email))
        {
            return password_verify($password, $user['password']);
        }
        else
        {
            return false;
        }
    }

    public function getUserByEmail($email){
        $sql ="SELECT * FROM users WHERE email = ?";
        $stmt = $this->cnx->prepare($sql);
        $stmt->bindParam(1,$email, PDO::PARAM_STR);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }
}
?>