@template.layout.page(
    content = @`
        <form action="/users" method="POST" class="container">
            <div class="input-group mb-3">
                <span class="input-group-text" style="width: 10%">First name</span>
                <input type="text"
                       class="form-control"
                       name="firstName"
                       aria-label="First name"
                       required />
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" style="width: 10%">Last name</span>
                <input type="text"
                       class="form-control"
                       name="lastName"
                       aria-label="Last name"
                       required />
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" style="width: 10%">Email</span>
                <input type="email"
                       class="form-control"
                       name="email"
                       aria-label="Email address"
                       required />
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" style="width: 10%">Password</span>
                <input type="password"
                       class="form-control"
                       name="password"
                       aria-label="Password"
                       required />
            </div>
            <input type="submit" class="btn btn-success" value="Зарегистрировать" />
        </form>
    `
)
