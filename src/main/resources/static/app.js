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

let Posts = {
  posts: {
    list: [],
    fetch: function () {
      m.request({
        method: 'GET',
        url: '/api/posts'
      }).then(function (response) {
        Posts.posts.list = response
      })
    }
  }
}

let Index = {
  onInit: Posts.posts.fetch(),
  view: function (vnode) {
    return Posts.posts.list.map(function (post) {
      return m('div', [
        m('strong', post.title),
        m('p', post.text),
        m('i', post.date)
      ])
    })
  }
}

let About = {
  view: function () {
    return m('p', 'This app is an example for Spring Boot, WebJars and SPAs!')
  }
}

m.route(container, '/posts', {
  '/posts': Index,
  '/about': About
})
