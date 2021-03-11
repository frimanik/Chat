<#import "parts/common.ftlh" as c>

<@c.page>
<h3>User messages</h3>
<#list outputList?sortBy("id")?reverse as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <strong>${message.authorName}</strong>
    <i>${message.tag}</i>
</div>
</#list>
</@c.page>