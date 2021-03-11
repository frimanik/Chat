<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

<h3>Login page</h3>
<@l.login "/login" />

<#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
<div class="error">
    ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
</div>
</#if>


<a href="/registration">Sign Up</a>
</@c.page>
