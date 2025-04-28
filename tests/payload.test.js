// tests/payload.test.js
const assert = require('assert');

function generatePayload() {
  return {
    username: "GitHub Bot",
    content: "🚀 Teste de notificação"
  };
}

describe('Teste do Payload', () => {
  it('Deve gerar payload corretamente', () => {
    const payload = generatePayload();
    assert.ok(payload.username);
    assert.ok(payload.content.includes("🚀"));
  });
});
