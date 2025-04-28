const fs = require('fs');
const yaml = require('js-yaml');
const { spawnSync } = require('child_process');

describe('GitHub Actions Workflow', () => {
  let workflow;

  before(() => {
    const file = fs.readFileSync('.github/workflows/discord-alerts.yml', 'utf8');
    workflow = yaml.load(file);
  });

  it('should have correct triggers', () => {
    assert.ok(workflow.on.push);
    assert.deepStrictEqual(workflow.on.push.branches, ['main']);
    assert.ok(workflow.on.pull_request);
  });

  it('should have valid job structure', () => {
    assert.ok(workflow.jobs.notify);
    assert.strictEqual(workflow.jobs.notify['runs-on'], 'ubuntu-latest');
  });

  it('should validate with act', function() {
    this.timeout(30000);
    const result = spawnSync('act', ['--dryrun'], { encoding: 'utf-8' });
    assert.strictEqual(result.status, 0, `act failed: ${result.stderr}`);
  });
});
