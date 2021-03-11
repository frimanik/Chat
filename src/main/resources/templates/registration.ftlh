<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<h3>Sign up</h3>
${message!}
<@l.login "/registration" />
</@c.page>