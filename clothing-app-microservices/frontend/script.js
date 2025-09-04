async function addUser() {
  const name = document.getElementById('user-name').value;
  const email = document.getElementById('user-email').value;
  const res = await fetch('/api/users', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, email })
  });
  const data = await res.json();
  const list = await fetch('/api/users').then(r=>r.json());
  document.getElementById('users-output').textContent = JSON.stringify(list, null, 2);
}

async function addProduct() {
  const name = document.getElementById('product-name').value;
  const price = Number(document.getElementById('product-price').value);
  const res = await fetch('/api/products', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ name, price })
  });
  const list = await fetch('/api/products').then(r=>r.json());
  document.getElementById('products-output').textContent = JSON.stringify(list, null, 2);
}

async function createOrder() {
  const userId = Number(document.getElementById('order-userId').value);
  const productId = Number(document.getElementById('order-productId').value);
  const res = await fetch('/api/orders', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ userId, productId })
  });
  const list = await fetch('/api/orders').then(r=>r.json());
  document.getElementById('orders-output').textContent = JSON.stringify(list, null, 2);
}
