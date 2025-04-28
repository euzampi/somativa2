const nock = require('nock');
const { sendNotification } = require('../scripts/notify'); // Você precisaria criar este módulo

describe('Discord Notification', () => {
  it('should send notification to Discord', async () => {
    const mock = nock('https://discord.com')
      .post('/api/webhooks/123/abc')
      .reply(200);
    
    await sendNotification('https://discord.com/api/webhooks/123/abc', { test: 'payload' });
    
    assert.ok(mock.isDone());
  });

  it('should handle Discord API errors', async () => {
    nock('https://discord.com')
      .post('/api/webhooks/123/abc')
      .reply(500);
    
    try {
      await sendNotification('https://discord.com/api/webhooks/123/abc', {});
      assert.fail('Should have thrown an error');
    } catch (err) {
      assert.ok(err.message.includes('500'));
    }
  });
});
