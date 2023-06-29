import request from '@/utils/request'

// 查询用户管理列表
export function listUser(query) {
  return request({
    url: '/fantuan/user/list',
    method: 'get',
    params: query
  })
}

// 查询用户管理详细
export function getUser(id) {
  return request({
    url: '/fantuan/user/' + id,
    method: 'get'
  })
}

// 新增用户管理
export function addUser(data) {
  return request({
    url: '/fantuan/user',
    method: 'post',
    data: data
  })
}

// 修改用户管理
export function updateUser(data) {
  return request({
    url: '/fantuan/user',
    method: 'put',
    data: data
  })
}

// 删除用户管理
export function delUser(id) {
  return request({
    url: '/fantuan/user/' + id,
    method: 'delete'
  })
}
