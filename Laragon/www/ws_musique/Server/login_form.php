<html>
<form method = "POST" action="userLogin.php">
    <div class="contianer">
        <h1>Connexion</h1>
        <p>Veuillez vous connectez.</p>
        <hr>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Email" name="email">

        <label for="password"><b>Password</b></label>
        <input name="password" placeholder="Mot de passe" type="password">

        <hr>

        <button type="submit" class="registerbtn">Valider</button>
    </div>

    <div class="container signin">
        <p>Pas encore inscrit ? <a href='register_form.php'>Inscrivez vous</a>.</p>
    </div>


</form>
</html>