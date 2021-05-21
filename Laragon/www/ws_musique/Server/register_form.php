<html>
<form method = "POST" action="userRegister.php">
    <div class="contianer">
        <h1>Enregistrement</h1>
        <p>Veuillez compléter le formulaire.</p>
        <hr>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Email" name="email">

        <label for="password"><b>Password</b></label>
        <input name="password" placeholder="Mot de passe" type="password">

        <hr>

        <button type="submit" class="registerbtn">Valider</button>
    </div>

    <div class="container signin">
        <p>Déjà inscrit ? <a href='login_form.php'>Connexion</a>.</p>
    </div>


</form>
</html>
