<#macro login path>
<form action="${path}" method="post">
    <div class="form-group row">
         <label class="col-sm-2 col-form-label"> User Name :</label>
        <div class="col-sm-5">
        <input type="text" name="username" class="form-control" placeholder="username"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password:</label>
        <div class="col-sm-5">
        <input type="password" name="password" class="form-control" placeholder="password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><button type="submit" class="btn btn-primary">Sign in</button></div>




</form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Sign out</button>
    </form>
</#macro>


<#macro loginRedirect>
    <form method="get" action="/login">
        <button type="submit" class="btn btn-primary">Sign In</button>
    </form>
</form>
</#macro>