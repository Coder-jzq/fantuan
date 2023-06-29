import request from '@/utils/request'

// 查询提现管理列表
export function listCashout(query) {
  return request({
    url: '/fantuan/cashout/list',
    method: 'get',
    params: query
  })
}

// 查询提现管理详细
export function getCashout(id) {
  return request({
    url: '/fantuan/cashout/' + id,
    method: 'get'
  })
}

// 新增提现管理
export function addCashout(data) {
  return request({
    url: '/fantuan/cashout',
    method: 'post',
    data: data
  })
}

// 修改提现管理
export function updateCashout(data) {
  return request({
    url: '/fantuan/cashout',
    method: 'put',
    data: data
  })
}

// 删除提现管理
export function delCashout(id) {
  return request({
    url: '/fantuan/cashout/' + id,
    method: 'delete'
  })
}
