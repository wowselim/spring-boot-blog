'use strict'

let container = document.querySelector('#main')

let Post = {
  view: function (vnode) {
    return m('div', [
      m('strong', vnode.attrs.title),
      m('p', vnode.attrs.text),
      m('i', vnode.attrs.date)
    ])
  }
}

let PostsService = {
  posts: {
    list: [],
    fetch: function () {
      m.request({
        method: 'GET',
        url: '/api/posts'
      }).then(function (response) {
        PostsService.posts.list = response
      })
    }
  }
}

let PostsRoute = {
  oninit: PostsService.posts.fetch(),
  oncreate: function (vnode) {
    setActivePage('#posts')
  },
  view: function (vnode) {
    return PostsService.posts.list.map(function (post) {
      return m('div.card', m('div.card-body', [
        m('div.card-title', [
          m('h5', post.title),
          m('div', post.date)
        ]),
        m('p.card-text', post.text),
        m('a.btn.btn-primary', {href: '#!/posts/' /* + post.id */}, 'Read more')
      ]))
    })
  }
}

let AboutRoute = {
  oncreate: function (vnode) {
    setActivePage('#about')
  },
  view: function () {
    return m('p', 'This app is an example for Spring Boot, WebJars and SPAs!')
  }
}

m.route(container, '/posts', {
  '/posts': PostsRoute,
  '/about': AboutRoute
})

function setActivePage (activePage) {
  document.querySelectorAll('.active').forEach(node => {
    node.classList.remove('active')
  })
  document.querySelector(activePage).classList.add('active')
}
